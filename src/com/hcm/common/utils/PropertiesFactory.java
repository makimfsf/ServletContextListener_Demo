package com.hcm.common.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 单例模式读取Properties属性文件
 * 
 * @author huangcongmin
 * @version , 2013-7-29
 * @since
 */
public class PropertiesFactory {

	/**
	 * 私有的属性防止外部引用
	 */
	private static PropertiesFactory _instance = null;
	private Properties properties = new Properties();

	/**
	 * 私有的默认构造函数，防止使用构造函数进行实例化
	 */
	private PropertiesFactory() {
		try {
			InputStream inputStream = this.getClass().getResourceAsStream("/jdbc.properties");
			properties.load(inputStream);
			if (inputStream != null)
				inputStream.close();
		} catch (Exception e) {
			System.out.println(e + "file not found");
		}
	}

	/**
	 * 单例静态工厂方法，同步防止多线程环境同时执行
	 * 
	 * @author huangcongmin
	 * @date 2013-7-29
	 * @return
	 */
	synchronized public static PropertiesFactory getInstance() {
		if (_instance == null) {
			_instance = new PropertiesFactory();
		}
		return _instance;
	}

	public PropertiesFactory clone() {
		return getInstance();
	}

	/**
	 * 读取配置信息key - value
	 * 
	 * @author huangcongmin
	 * @date 2013-7-29
	 * @param key
	 * @return
	 */
	public String getConfig(String key) {
		return properties.getProperty(key);
	}

}
