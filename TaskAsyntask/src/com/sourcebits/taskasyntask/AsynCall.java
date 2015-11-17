package com.sourcebits.taskasyntask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsynCall extends AsyncTask<Integer,Integer ,Integer>
{
	ProgressBar progress;
	TextView result;
	
    public AsynCall(ProgressBar progress, TextView result) 
    {
		this.progress = progress;
		this.result = result;
	}
    
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		progress.setVisibility( View.VISIBLE);
		progress.setMax(100);
		result.setText("0 / 100");
	}

	

	@Override
	protected Integer doInBackground(Integer... params) 
	{
		
		try {  
	        //int totalSecs = params[0].intValue();
	    
	        for (int i = 1; i <= 100; i++) {
	           
	           Thread.sleep(1000);
	  	     
	     
	           publishProgress(i);
	        }  
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	          return 0;
	      }
	 
	      return 1;
	}
	
	
	@Override
	protected void onProgressUpdate(Integer... values) 
	{
		
		super.onProgressUpdate(values[0]);
		
		progress.setProgress(values[0]);
		String s = values[0]+" / 100";
		result.setText(s);
	}


	
	@Override
	protected void onPostExecute(Integer result)
	{
		super.onPostExecute(result);
		progress.setProgress(0);
		progress.setVisibility( View.INVISIBLE);
		
		
	}
	
	

}
