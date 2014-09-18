package com.AandC.GemsCraft.Players;
import com.AandC.GemsCraft.World.*;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Console.*;
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
public class Console extends Player
{
	@Override
	public String Nick = "Console";
	@Override
	public String userName = "Console";
	@Override
	public Block heldBlock = null;
	@Override
	public int posX = 0;
	@Override
	public int posY = 0;
	@Override
	public int posZ = 0;
	@Override
	public boolean isAFK = false;
	@Override
	public void performCommand(Command cmd) {
		cmd.run(this);
	}

	@Override
	public void message(String mes){
		try
		{
			Log mess = new Log(mes);
		} catch (InvalidLogException e) {
			e.printStackTrace();
		}
	}
}
