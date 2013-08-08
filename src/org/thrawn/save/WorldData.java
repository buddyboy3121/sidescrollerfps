package org.thrawn.save;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.thrawn.world.LevelData;

public class WorldData {
	
	public void save() throws IOException {
		
		FileOutputStream output = new FileOutputStream("/Users/Nacorpio/Desktop/world.txt");
		BufferedOutputStream buf_output = new BufferedOutputStream(output);
		
		byte[][][] data = {};
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				for (int k = 0; k < data[i][j].length; k++) {
					
					// Write the data to the file and then flush.
					buf_output.write(data[i][j][k]);
					buf_output.flush();
					
				}
			}
		}
		
		FileInputStream input = new FileInputStream("/Users/Nacorpio/Desktop/world.txt");
		BufferedInputStream buf_input = new BufferedInputStream(input);
		
		for (int i = 0; i < buf_input.available(); i++) {
			int buf = buf_input.read();
			System.out.println(buf);
		}
		
		buf_input.close();
		buf_output.close();
		
	}
	
}
