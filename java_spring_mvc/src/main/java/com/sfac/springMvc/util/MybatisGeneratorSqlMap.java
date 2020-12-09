package com.sfac.springMvc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Description: Mybatis Generator Sql Map
 * @author HymanHu
 * @date 2020-12-09 11:10:11
 */
public class MybatisGeneratorSqlMap {
	public void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		// 指定配置文件
		File configFile = new File(
				MybatisGeneratorSqlMap.class.getResource("/config/mybatisGeneratorConfig.xml").getPath());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	// 执行main方法以生成代码
	public static void main(String[] args) {
		try {
			MybatisGeneratorSqlMap generatorSqlmap = new MybatisGeneratorSqlMap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
