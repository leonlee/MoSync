/* Copyright (C) 2011 MoSync AB

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License,
version 2, as published by the Free Software Foundation.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
MA 02110-1301, USA.
*/

package com.mosync.nativeui.ui.factories;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.mosync.internal.android.EventQueue;
import com.mosync.nativeui.ui.widgets.CheckBoxWidget;
import com.mosync.nativeui.ui.widgets.Widget;

/**
 * Creates a check box widget, that sends events once it's
 * state changes.
 * 
 * @author fmattias
 */
public class CheckBoxFactory implements AbstractViewFactory
{

	@Override
	public Widget create(Activity activity, final int handle)
	{
		CheckBox checkBox = new CheckBox( activity );
		checkBox.setOnCheckedChangeListener( new OnCheckedChangeListener( ) {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				EventQueue.getDefault( ).postWidgetClickedEvent( handle, isChecked );
			}
		});
		
		return new CheckBoxWidget( handle, checkBox );
	}
	
	
}
