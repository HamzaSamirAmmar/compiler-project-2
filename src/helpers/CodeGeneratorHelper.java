package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGeneratorHelper {
    public static void generateControllersMutualFiles(){
       generateCheckValidFile();
       generateCheckRoleFile();
       generateCheckInRolesFile();
       generateCheckAuthFile();
       generateRedirectFile();
       //generateConfigFiles();

    }
    protected static void generateCheckValidFile(){
        String fileName="generatedCode/util/checkValid.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write("<?php\n" +
                    "include 'usersConfig.php';\n" +
                    "\n" +
                    "function checkValid($userName,$password) {\n" +
                    "    global $users;\n" +
                    "    $valid=false;\n" +
                    "    if($users[$userName]==$password)\n" +
                    "        $valid=1;\n" +
                    "    $_SESSION['user']=$userName;\n" +
                    "    return $valid;\n" +
                    "}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void generateCheckRoleFile(){
        String fileName="generatedCode/util/checkRole.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write(
                    "<?php\n" +
                    "include 'rolesConfig.php';\n" +
                    "\n" +
                    "function checkRole($role) {\n" +
                    "    $usersRoles=$GLOBALS['usersRoles'];\n" +
                    "    $authorized=false;\n" +
                    "    if(isset($_SESSION['user'])){\n" +
                    "     if(in_array($role,$usersRoles[$_SESSION['user']]))\n" +
                    "        {\n" +
                    "            $authorized=true;\n" +
                    "        }\n" +
                    "    }\n" +
                    "    return $authorized;\n" +
                    "}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void generateCheckInRolesFile(){
        String fileName="generatedCode/util/checkInRoles.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write("<?php\n" +
                    "include 'rolesConfig.php';\n" +
                    "\n" +
                    "function checkInRoles($roles) {\n" +
                    "    $usersRoles=$GLOBALS['usersRoles'];\n" +
                    "    $authorized=false;\n" +
                    "    foreach($roles as $role){\n" +
                    "        if(isset($_SESSION['user']))\n" +
                    "        { \n" +
                    "            if(in_array($role,$usersRoles[$_SESSION['user']]))\n" +
                    "            {\n" +
                    "                $authorized=true;\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }   \n" +
                    "    return $authorized;\n" +
                    "}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void generateCheckAuthFile(){
        String fileName="generatedCode/util/checkAuth.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write("<?php\n" +
                    "function checkAuth() {\n" +
                    "    if(isset( $_SESSION['user']))\n" +
                    "        return true;\n" +
                    "    else \n" +
                    "        return false;\n" +
                    "}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void generateRedirectFile(){
        String fileName="generatedCode/util/redirect.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write("<?php \n" +
                    "function redirect($targetPageId){\n" +
                    "header(\"Location:\".$targetPageId.'.php');\n" +
                    "exit;\n" +
                    "}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void generateConfigFiles(){
        //users config file
        String fileName="generatedCode/util/usersConfig.php";
        File file = new File(fileName);
        FileWriter fileWriter=null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(fileName);
            fileWriter.write("<?php\n" +
                    "//set of users : name => password\n" +
                    "$users=\n" +
                    "[\n" +
                    "'rana'=>'123456789',\n" +
                    "'alaa'=>'123456'\n" +
                    "];\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //roles config file
        String fileName2="generatedCode/util/rolesConfig.php";
        File file2 = new File(fileName2);
        FileWriter fileWriter2=null;
        try {
            file2.createNewFile();
            fileWriter2 = new FileWriter(fileName2);
            fileWriter2.write("<?php\n" +
                    "//set of user roles : name => array of role names\n" +
                    "$usersRoles=[\n" +
                    "    'rana'=>['admin'],\n" +
                    "    'alaa'=>['user']\n" +
                    " ];");
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
