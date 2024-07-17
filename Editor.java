import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Editor {
      public static void main(String[] args) {
            String dosyaAdi = null;
            String fonksiyon = null ;
            String input1 = null ;
            String input2 = null ;
            
            dosyaAdi = args[0];
            fonksiyon = args[1];
            
            PrintWriter writer = null ; 
            PrintWriter writer2 = null ;
            try{
                  writer = new PrintWriter(new FileOutputStream("temp.txt"));
            } catch(FileNotFoundException e) {

                  e.printStackTrace();
            }
           
            
            Scanner reader = null ;  
            Scanner reader2 = null ;
            
                  try {
                        reader = new Scanner(new FileInputStream(dosyaAdi));
                  } catch (FileNotFoundException e) {
                        
                        e.printStackTrace();
                  }
                  try {
                        reader2 = new Scanner(new FileInputStream("temp.txt"));
                  } catch (FileNotFoundException e) {
                        
                        e.printStackTrace();
                  }
                
            if(fonksiyon.equals("degistir")){
                  input1 = args[2];
                  input2 = args[3];
                  String line ;
                  while(reader.hasNextLine()){
                        line = reader.nextLine();
                        line = line.replaceAll(input1,input2);
                        writer.println(line);

                  }   
                  writer.close();
                  try{
                        writer2 = new PrintWriter(new FileOutputStream(dosyaAdi));
                  } catch(FileNotFoundException e) {
      
                        e.printStackTrace();
                  }

                  while(reader2.hasNextLine()){
                        line = reader2.nextLine();
                        writer2.println(line);
                  }

                  writer2.close();
                  reader.close();
                  reader2.close();
            }
            else if(fonksiyon.equals("sil")){
                  input1 = args[2];
           
                  String line ;
                  while(reader.hasNextLine()){
                        line = reader.nextLine();
                        line = line.replaceAll(input1,"");
                        writer.println(line);

                  }   
                  writer.close();
                  try{
                        writer2 = new PrintWriter(new FileOutputStream(dosyaAdi));
                  } catch(FileNotFoundException e) {
      
                        e.printStackTrace();
                  }

                  while(reader2.hasNextLine()){
                        line = reader2.nextLine();
                        writer2.println(line);
                  }

                  writer2.close();
                  reader.close();
                  reader2.close();
            }

            else if(fonksiyon.equals("kelimeSay")){
                  input1 = args[2];
                  String line ;
                  int sayac = 0 ;
                  while(reader.hasNext()){
                        line = reader.next();
                        if(line.contains(input1)){
                              sayac++ ;
                        }
                  }
                  writer.close();
                  reader.close();
                  reader2.close();
                  System.out.println(sayac);
                  
            }
            else if(fonksiyon.equals("tamKelimeSay")){
                  input1 = args[2];
                  String line ;
                  int sayac = 0 ;
                  while(reader.hasNext()){
                        line = reader.next();
                        
                        if(line.contains(input1)){
                              
                              sayac++ ;
                        }
                        if(!(line.contains(".")||line.contains(",")||line.contains(";")||line.contains(":"))){
                              if(line.length()>input1.length()){
                                    if(line.contains(input1)){
                                          sayac-- ;
                                    }
                                    
                              }
                        }
                  }
                  writer.close();
                  reader.close();
                  reader2.close();
                  System.out.println(sayac);


            }
            else if(fonksiyon.equals("kopyala")){
                  input1 = args[2];
                  
                  String line ;
                  try{
                        writer2 = new PrintWriter(new FileOutputStream(input1));
                  } catch(FileNotFoundException e) {
      
                        e.printStackTrace();
                  }

                  while(reader.hasNextLine()){
                        line = reader.nextLine();
                        writer2.println(line);
                  }
                  writer.close();
                  reader.close();
                  reader2.close();
                  writer2.close();
            }
            else{
                  System.out.println("Bir hata var...");
                  System.exit(0);
            }

      }
}
