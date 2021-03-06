package com.AandC.GemsCraft.Configuration;
import android.app.*;
import android.os.*;
import com.AandC.GemsCraft.*;
import com.AandC.GemsCraft.System.*;
import android.widget.*;
import org.json.*;
import java.io.*;
import android.view.*;
import android.nfc.*;
import com.AandC.GemsCraft.Exceptions.*;
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
public class ConfigActivity extends Activity
{
	@Override
	private EditText[] textBoxes = new EditText[3];
	public void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.config);
		Contexts.configActivityContext = this;
		textBoxes[0] = (EditText) findViewById(R.id.txtServerName);
		textBoxes[1] = (EditText) findViewById(R.id.txtPorts);
		textBoxes[2] = (EditText) findViewById(R.id.txtM);
		ConfigKey.configs = this.textBoxes;
		loadConfig();
	}
	void loadConfig() {
		if (Config.configFile.exists()) {
			textBoxes[0].setText(ConfigKey.getServerName());
			textBoxes[1].setText("" + ConfigKey.getPort());
			textBoxes[2].setText(ConfigKey.getMOTD());
		}
	}
	public void save(View v) {
		try {
			String name = textBoxes[0].getText().toString();
			String Port = textBoxes[1].getText().toString();
			String MO = textBoxes[2].getText().toString();
			int FormattedPort = Integer.parseInt(Port);
			if (FormattedPort >= 65535 || FormattedPort < 0) {
				throw new NumberFormatException();
			}
			if (name.length() > 40) {
				throw new ServerNameFormatException();
			}
			try
			{
				ConfigKey.setServerName();
				ConfigKey.setPort();
				ConfigKey.setMOTD();
				MsgBox.show("Server Name = " + textBoxes[0].getText().toString(),
					"MOTD = " + textBoxes[2].getText().toString(), this);
				Config.writeConfig();
			} catch (Exception e) {
				MsgBox.show("Errors", "There was a serious error that has caused the app to close", this);
				System.exit(0);
			}
		} catch (NullPointerException ex) {
			MsgBox.show("Errors", "Please fill in all items", this);
		} catch (NumberFormatException ex) {
			MsgBox.show("Errors","Invalid Port", this);
		} catch (ServerNameFormatException ex) {
			MsgBox.show("Errors","Server Name is too long!", this);
		}
	}
}
