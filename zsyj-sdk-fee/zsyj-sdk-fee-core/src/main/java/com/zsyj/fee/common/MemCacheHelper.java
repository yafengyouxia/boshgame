package com.zsyj.fee.common;

import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * MemCache缓存帮助对象
 * 
 * telnet 127.0.0.1 11211 远程登录
 * 
 * stats 查看memcache状态
 * 
 * stats items 遍历节点
 * 
 * @author Raymond
 */
public class MemCacheHelper {

	protected static MemCachedClient mcc = new MemCachedClient();
	
	private static Log logger = LogFactory.getLog(MemCacheHelper.class.getName());
	
	static {
		ResourceBundle cacheBundle = ResourceBundle
				.getBundle("config");
		String[] servers = cacheBundle.getString("memCachedServers").split(",");
		Integer[] weights = new Integer[servers.length];
		for (int i = 0; i < servers.length; i++) {
			weights[i] = 3;
		}
		// 创建一个实例对象SockIOPool
		SockIOPool pool = SockIOPool.getInstance();

		// set the servers and the weights
		// 设置Memcached Server
		pool.setServers(servers);
		pool.setWeights(weights);

		// set some basic pool settings
		// 5 initial, 5 min, and 250 max conns
		// and set the max idle time for a conn
		// to 6 hours
		pool.setInitConn(50);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle( 1000*3600*1 );
		
		// set the sleep for the maint thread
		// it will wake up every x seconds and
		// maintain the pool size
		pool.setMaintSleep(30);
		
		// Tcp的规则就是在发送一个包之前，本地机器会等待远程主机
		// 对上一次发送的包的确认信息到来；这个方法就可以关闭套接字的缓存，
		// 以至这个包准备好了就发；
		pool.setNagle(false);
		// 连接建立后对超时的控制
		pool.setSocketTO(1000);
		
		pool.setAliveCheck(true);

		// initialize the connection pool
		// 初始化一些值并与MemcachedServer段建立连接
		pool.initialize();
	}

	/**
	 * set value
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(String key, Object value) {
		return mcc.set(key, value);
	}

	/**
	 * set value and given expire time
	 * 
	 * @param key
	 * @param value
	 * @param expireSecond 单位秒
	 * @return
	 */
	public static boolean set(String key, Object value, long expireSecond) {
		return mcc.set(key, value, new Date(System.currentTimeMillis()+expireSecond) );
	}

	/**
	 * Adds data to the server; the key, value, and an expiration time are
	 * specified.
	 * 
	 * @param key
	 * @param value
	 * @param expireSecond
	 * @return
	 */
	public static boolean add(String key, Object value, long expireSecond) {
		return mcc.add(key, value, new Date(System.currentTimeMillis()+expireSecond) );
	}


	/**
	 * Updates data on the server; the key, value, and an expiration time are
	 * specified.
	 * 
	 * @param key
	 * @param value
	 * @param expiry
	 * @return
	 */
	public static boolean replace(String key, Object value, long expireSecond) {
		return mcc.replace(key, value, new Date(System.currentTimeMillis()+expireSecond) );
	}

	/**
	 * Deletes an object from cache given cache key.
	 * 
	 * @param key
	 * @return
	 */
	public static boolean delete(String key) {
		return mcc.delete(key);
	}

	/**
	 * Deletes an object from cache given cache key and expiration date.
	 * 
	 * @param key
	 *            the key to be removed
	 * @param expiry
	 *            when to expire the record.
	 * @return <code>true</code>, if the data was deleted successfully
	 */
	public static boolean delete(String key, Date expiry) {
		return mcc.delete(key, expiry);
	}

	/**
	 * Retrieve a key from the server, using a specific hash.
	 * 
	 * If the data was compressed or serialized when compressed, it will
	 * automatically<br/>
	 * be decompressed or serialized, as appropriate. (Inclusive or)<br/>
	 *<br/>
	 * Non-serialized data will be returned as a string, so explicit conversion
	 * to<br/>
	 * numeric types will be necessary, if desired<br/>
	 * 
	 * @param key
	 *            key where data is stored
	 * @return the object that was previously stored, or null if it was not
	 *         previously stored
	 */
	public static Object get(String key) {
		
		Object result = null;
		try
		{
			result = mcc.get(key);	
		}
		catch( Exception e )
		{
			result = null;
			logger.error( e.getMessage() + " key:" + key );
		}
		
//		if( result == null ) {
//			logger.info( key );
//		}
		
		return result;
	}


	/**
	 * Retrieve multiple objects from the memcache.
	 * 
	 * This is recommended over repeated calls to {@link #get(String) get()},
	 * since it<br/>
	 * is more efficient.<br/>
	 * 
	 * @param keys
	 *            String array of keys to retrieve
	 * @return Object array ordered in same order as key array containing
	 *         results
	 */
	public static Object[] getMultiArray(String[] keys) {
		return mcc.getMultiArray(keys);
	}

	/**
	 * Retrieve multiple objects from the memcache.
	 * 
	 * This is recommended over repeated calls to {@link #get(String) get()},
	 * since it<br/>
	 * is more efficient.<br/>
	 * 
	 * @param keys
	 *            String array of keys to retrieve
	 * @return a hashmap with entries for each key is found by the server, keys
	 *         that are not found are not entered into the hashmap, but
	 *         attempting to retrieve them from the hashmap gives you null.
	 */
	public static Map<String, Object> getMulti(String[] keys) {
		return mcc.getMulti(keys);
	}
	
	public static void main( String args [] )
	{
		System.out.println( new Date( 180*1000 ) );
	}
}