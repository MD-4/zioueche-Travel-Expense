package app.zioueche_travelexpense;
/*Copyright [2015] [Omar Zioueche]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0*/


/* 
 * 
 *This code has been cited from the source. I found this code while looking for a custom way to display information on the listview. 
 * 
 */



import java.text.DateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
//taken and modified from https://devtut.wordpress.com/2011/06/09/custom-arrayadapter-for-a-listview-android/ JAN/ 13/2015
public class CustomAdapterExpense extends ArrayAdapter<Expense> {
	private ArrayList<Expense> objects;

	/* here we must override the constructor for ArrayAdapter
	* the only variable we care about now is ArrayList<Item> objects,
	* because it is the list of objects we want to display.
	*/
	public CustomAdapterExpense(Context context, int textViewResourceId, ArrayList<Expense> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects;
	}

	public View getView(int position, View convertView, ViewGroup parent){

		// assign the view we are converting to a local variable
		View v = convertView;

		// first check to see if the view is null. if so, we have to inflate it.
		// to inflate it basically means to render, or show, the view.
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.custom_view_claim, null);
		}

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 * 
		 * Therefore, i refers to the current Item object.
		 */
		Expense i = objects.get(position);

		if (i != null) {

			// This is how you obtain a reference to the TextViews.
			// These TextViews are created in the XML files we defined.
			TextView tt = (TextView) v.findViewById(R.id.toptext);
			TextView ttd = (TextView) v.findViewById(R.id.toptextdata);
			TextView mt = (TextView) v.findViewById(R.id.middletext);
			TextView mtd = (TextView) v.findViewById(R.id.middletextdata);
			//TextView bt = (TextView) v.findViewById(R.id.bottomtext);
			//TextView btd = (TextView) v.findViewById(R.id.desctext);

			// check to see if each individual textview is null.
			// if not, assign some text!
			if (tt != null){
				tt.setText("Name: ");
			}
			if (ttd != null){
				ttd.setText(i.getName());
			}
			if (mt != null){
				mt.setText("Start Date: ");
			}
			if (mtd != null){
				mtd.setText("" + DateFormat.getDateInstance().format(i.getCDate()));
			}
			//if (bt != null){
			//	bt.setText("Currency: ");
			//}
			//if (btd != null){
			//	btd.setText("     "+i.getPrice()+" "+i.getCurrency());
			//}
		}

		// the view must be returned to our activity
		return v;
	}
}
