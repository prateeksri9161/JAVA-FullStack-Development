

function SubmitTestForm() {
	
	
	//TODO: Call postFormDataAsJson to http://localhost:8090/ecommerce/feedback
  alert("The form was submitted");
}

/**
 
 *
 * @param {Object} options
 * @param {string} options.url - URL to POST data to
 * @param {FormData} options.formData - `FormData` instance
 * @return {Object} - Response body from URL that was POSTed to
 */
async function postFormDataAsJson({ url, formData }) {
	/**
	 
	
	 * 
	 * @see https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/POST
	 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/fromEntries
	 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
	 */
	const plainFormData = Object.fromEntries(formData.entries());
	const formDataJsonString = JSON.stringify(plainFormData);

	const fetchOptions = {
		
		method: "POST",
	
		headers: {
			"Content-Type": "application/json",
			"Accept": "application/json"
		},
		
		body: formDataJsonString,
	};

	const response = await fetch(url, fetchOptions);

	if (!response.ok) {
		const errorMessage = await response.text();
		throw new Error(errorMessage);
	}

	return response.json();
}