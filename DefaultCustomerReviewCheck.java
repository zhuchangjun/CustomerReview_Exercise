package de.hybris.platform.customerreview.impl;

import de.hybris.platform.jalo.JaloInvalidParameterException;
import java.util.*;
import java.io.*;

public class DefaultCustomerReviewCheck
  extends AbstractBusinessService
  implements CustomerReviewCheck
{
		private Vector<String> curseWords = new Vector<String>();
		
		DefaultCustomerReviewCheck()
	  {
	  		try
				{
    				InputStream fis = new FileInputStream("cursewords.txt");
    				InputStreamReader isr = new InputStreamReader(fis);
    				BufferedReader br = new BufferedReader(isr);
						String line = "";
    				while ((line = br.readLine()) != null) {
										curseWords.add(line);
					  }
				}
				catch(Exception e)
				{e.printStackTrace();} 
		}
		public void checkComment(String comment) throws JaloInvalidParameterException
		{
				for(int i = 0; i < curseWords.size(); i++)
				{
								if(comment.indexOf(curseWords.get(i)) != -1)
								{
							       throw new JaloInvalidParameterException("Curse word in comment!");
								} 
				}
		}
}
