package com.sfac.springMvc.config;

import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

/**
 * Description: Hibernate Naming Strategy
 * -Hibernate5 中自定义实体类与数据库命名规则的方法相比之前版本有较大改变
 * -Hibernate5 之前的版本实现 NamingStrategy 就可以实现自定义规则
 * -Hibernate5 改为通过 ImplicitNamingStrategy 与 PhysicalNamingStrategy 实现
 * -ImplicitNamingStrategy：隐式规则，实体 Bean 注解优先，未配置才采用该规则
 * -PhysicalNamingStrategy：物理规则，不管实体 Bean 是否有注解，都按该规则执行
 * -配置链
 * -LocalSessionFactoryBean
 * ---private ImplicitNamingStrategy implicitNamingStrategy;
 * -----ImplicitNamingStrategyJpaCompliantImpl
 * ---private PhysicalNamingStrategy physicalNamingStrategy;
 * -----PhysicalNamingStrategyStandardImpl
 * -----SpringPhysicalNamingStrategy
 * -该类继承了 ImplicitNamingStrategyJpaCompliantImpl，重写了生成列名方法，采用驼峰转下划线的规则
 * @author HymanHu
 * @date 2021-01-21 15:37:31
 */
public class HibernateNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	private static final long serialVersionUID = 1L;

	// 自定义列名生成规则
	@Override
	public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
		String name = transformAttributePath(source.getAttributePath());
		name = addUnderscores(name);
		return toIdentifier(name, source.getBuildingContext());
	}
	
	// 驼峰转下划线
	protected static String addUnderscores(String name) {
		StringBuilder buf = new StringBuilder( name.replace('.', '_') );
		for (int i=1; i<buf.length()-1; i++) {
			if (
				Character.isLowerCase( buf.charAt(i-1) ) &&
				Character.isUpperCase( buf.charAt(i) ) &&
				Character.isLowerCase( buf.charAt(i+1) )
			) {
				buf.insert(i++, '_');
			}
		}
		return buf.toString().toLowerCase(Locale.ROOT);
	}

}
