package br.com.digitalhouse.bootcampbrspring.configuration.response;

public class SuccessResponse<T> {
	
	T data;

	public SuccessResponse(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
