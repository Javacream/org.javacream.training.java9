package org.javacream.training.java9.jigsaw.helloworld;

public class HelloResponse {

	private String response;

	@Override
	public String toString() {
		return "HelloResponse [response=" + response + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		return result;
	}

	public HelloResponse(String response) {
		super();
		this.response = response;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HelloResponse other = (HelloResponse) obj;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}

	public String getResponse() {
		return response;
	}
}
