/**   
*
* 
* 
*/
package com.wrp.ssm.exception;

/**   
* @Title: CustomException.java 
* @Description: 系统自定义异常类，针对预期的异常，需要在程序中抛出此类的异常
* @author LYleonard
*/
public class CustomException extends Exception{
	
	private static final long serialVersionUID = 1L;
	// 异常信息
	public String message;
	
	public CustomException (String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
