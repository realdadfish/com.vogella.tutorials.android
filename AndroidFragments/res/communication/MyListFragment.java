package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment {

	private OnItemSelectedListener listener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rsslist_overview,
				container, false);
		Button button = (Button) view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateDetail("fake");
			}
		});
		return view;
	}

	public interface OnItemSelectedListener {
		public void onRssItemSelected(String link);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnItemSelectedListener) {
			listener = (OnItemSelectedListener) context;
		} else {
			throw new ClassCastException(context.toString()
					+ " must implemenet MyListFragment.OnItemSelectedListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

	// may also be triggered from the Activity
	public void updateDetail(String uri) {
		// create a string just for testing
		String newTime = String.valueOf(System.currentTimeMillis());

		// inform the Activity about the change based
		// interface defintion
		listener.onRssItemSelected(newTime);
	}
}