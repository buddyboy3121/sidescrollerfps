   package org.main;
   
   
   
   class BugNet{
   try {
       System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));
   } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
  }
