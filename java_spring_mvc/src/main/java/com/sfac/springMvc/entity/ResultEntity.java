package com.sfac.springMvc.entity;

/**
 * Description: Result Entity
 * @author HymanHu
 * @date 2020-12-09 16:01:47
 */
public class ResultEntity<T> {

	private int status;
	private String message;
	private T data;

	public ResultEntity() {
	}

	public ResultEntity(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResultEntity(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Description: Result Status
	 * @author HymanHu
	 * @date 2020-12-09 16:06:12
	 */
	public enum ResultStatus {
		
		SUCCESS(200), FAILED(500);

		public int status;

		private ResultStatus(int status) {
			this.status = status;
		}
	}
}
