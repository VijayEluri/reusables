// Diagnostic.java

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

import java.util.logging.Logger;

import com.webobjects.eocontrol.EOObserving;
import com.webobjects.foundation.NSNotification;
import com.webobjects.foundation.NSSelector;

@Deprecated
public class Diagnostic implements EOObserving {
	private static final Logger logger = Logger.getLogger("rujel.reusables");
	public static final NSSelector dumpNotificationSelector = new NSSelector(
			"dumpNotification", new Class[] {NSNotification.class});
	
	public static final Diagnostic INSTANCE = new Diagnostic();

	public void dumpNotification(NSNotification ntf) {
		logger.log(WOLogLevel.INFO, "Received notification: " + ntf.name(),
			new Object[] {ntf.object(), ntf.userInfo(), new Exception()});
//		System.err.println(notification.toString());
//		Thread.dumpStack();
	}

	
	public void objectWillChange(Object obj) {
		logger.log(WOLogLevel.INFO, "Object will change",
				new Object[] {obj, new Exception()});
	}

}
