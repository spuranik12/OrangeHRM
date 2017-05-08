package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadInputProperties 
{
	public static String GetValue(String Key)
	{
		String GetValue = " ";
		Properties prop = new Properties();
		InputStream input = null;
		
		try
		{
			input = new FileInputStream(System.getProperty("user.dir") + "//ObjectRepo//Object.properties");
			
			prop.load(input);
			GetValue = prop.getProperty(Key);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (input != null)
			{
				try
				{
					input.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return GetValue; 
	}
}
