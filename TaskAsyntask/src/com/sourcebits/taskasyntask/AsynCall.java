package com.sourcebits.taskasyntask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

public class AsynCall extends AsyncTask<Integer,Integer ,Integer>
{
	ProgressBar progress;
	
    public AsynCall(ProgressBar progress) 
    {
		this.progress = progress;
	}
    
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		progress.setVisibility( View.VISIBLE);
		progress.setMax(60);
	}

	

	@Override
	protected Integer doInBackground(Integer... params) 
	{
		
		try {  
	        int totalSecs = params[0].intValue();
	    
	        for (int i = 1; i <= totalSecs; i++) {
	           
	           Integer[] percentage = new Integer[1000*60];
	           Thread.sleep(percentage.length);
	  	     
	     
	           publishProgress(percentage);
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
	}


	
	@Override
	protected void onPostExecute(Integer result)
	{
		super.onPostExecute(result);
		progress.setProgress(0);
		progress.setVisibility( View.INVISIBLE);
		
		
	}
	
	

}
