package com.AandC.GemsCraft.Console;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Console.LogTypes.*;
import com.AandC.GemsCraft.*;
import android.text.*;
import android.text.format.*;
import com.AandC.GemsCraft.System.*;
/*
 The MIT License (MIT)

 Copyright (c) 2014 Alex Potter

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
public class Log
{
	String msg;
	LogType toSrnd;
	public void Send() {
		write(msg, toSrnd);
	}
	public Log(String message) throws InvalidLogException {
		if (message.equals(null)) {
			throw new InvalidLogException("Log Message cannot be null",
				new NullPointerException());
		} else {
			msg = message;
			toSrnd = new Normal();
		}
	}
	public Log(String message, LogType lType) throws InvalidLogException {
		if (message.equals(null) || lType.equals(null)) {
			throw new InvalidLogException("Log Message cannot be null",
										  new NullPointerException());
		} else {
			msg = message;
			toSrnd = lType;
		}
	}
	public static String hbLogs;
	String htmlEnd = "</body></html>";
	void write(String message, LogType l) {
		Constants.htmlStart += "<p style=\"" + l.hexColor + "\"" + "> " +
			"&#60 " + Constants.getTime() + " &#62" + " " +
			message + "</p>";
		String finalMessage = Constants.htmlStart + htmlEnd;
		Constants.consoleTextView.setText(Html.fromHtml(finalMessage));
	}
}
