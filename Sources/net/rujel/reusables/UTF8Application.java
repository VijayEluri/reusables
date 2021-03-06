// UTF8Application.java

/*
 * Copyright (c) 2008, Gennady & Michael Kushnir
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * 	•	Redistributions of source code must retain the above copyright notice, this
 * 		list of conditions and the following disclaimer.
 * 	•	Redistributions in binary form must reproduce the above copyright notice,
 * 		this list of conditions and the following disclaimer in the documentation
 * 		and/or other materials provided with the distribution.
 * 	•	Neither the name of the RUJEL nor the names of its contributors may be used
 * 		to endorse or promote products derived from this software without specific 
 * 		prior written permission.
 * 		
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.rujel.reusables;

import com.webobjects.foundation.*;
import com.webobjects.appserver.*;

public class UTF8Application extends WOApplication {
	/*
		public UTF8Application() {
			super();
			WOMessage.setDefaultURLEncoding(_NSUtilities.UTF8StringEncoding);
			WOMessage.setDefaultEncoding(_NSUtilities.UTF8StringEncoding);
		}*/
		@SuppressWarnings("static-access")
		public WOResponse dispatchRequest(WORequest aRequest) {
			aRequest.setDefaultFormValueEncoding(_NSUtilities.UTF8StringEncoding);
			//refactor for 5.4
			aRequest.setDefaultURLEncoding(_NSUtilities.UTF8StringEncoding);
			WOResponse response = super.dispatchRequest(aRequest);
			String contentType = response.headerForKey("Content-Type");
			if(contentType != null && !contentType.startsWith("text/html"))
				return response;
			if (_NSUtilities.UTF8StringEncoding.equals(response.contentEncoding()))
				response.setHeader("text/html; charset=UTF-8","Content-Type");
			return response;
		 }
	
		public WOResponse createResponseInContext(WOContext wocontext) {
			WOResponse woresponse = super.createResponseInContext(wocontext);
			woresponse.setContentEncoding(_NSUtilities.UTF8StringEncoding);
			//woresponse.setHeader("text/html; charset=UTF-8","Content-Type");
			//woresponse.appendContentString("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
			return woresponse;
		}		
}
