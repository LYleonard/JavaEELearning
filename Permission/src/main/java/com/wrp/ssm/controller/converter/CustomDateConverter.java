package com.wrp.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**   
* @Title: CustomDateConverter.java 
* @Description: 自定义日期类型的转换器
* @author LYleonard  
*/
public class CustomDateConverter implements Converter<String, Date>{
	
	@Override
	public Date convert(String source) {
		
		// 实现 将日期串转换成日期类型（ 格式是yyyy-MM-dd HH:mm:ss ）
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			// 转换成功直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 参数绑定失败则返回null
		return null;
	}
	
}
