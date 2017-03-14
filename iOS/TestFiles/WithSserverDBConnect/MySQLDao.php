<?php

class MySQLDao{ //mySQL data access object

  var $dbhost = null;
  var $dbuser = null;
  var $dbpass = null;
  var $con = null;
  var $dbname = null;
  var $result = null;

  function_construct(){
    $this->dbhost = Conn::$dbhost;
    $this->dbuser = Conn::$dbuser;
    $this->dbpass = Conn::$dbpass;
    $this->dbname = Conn::$dbname;

  }

  public function openConnection(){
    $this->conn = new MysqlndUhConnection($this->dbhost,$this->dbuser,$this->dbpass,$this->dbname);
    if(mysqli_connect_errno())
    echo new Exception("Could not establish connection with database");
  }

  public function getConnection(){
    return $this->conn;
  }

  public function closeConnection(){
    if($this->conn != null)
    $this->conn->close();
  }

  public function getUserDetails($email){
    $retutnValue = array();
    $sql = "select * from users where user_email='".$email."'";

    $result = $this->conn->query($sql);
    if($result != null && (mysqli_num_row($result)>=1)){
      $row = $result->fetch_array(MYSQLI_ASSOC);
      if(!empty($row)){
        $retutnvalue = $row;
      }
    }
    return $returnValue;
  }



public function getUserDetailsWithPassword($email, $userPassword){
  $returnValue = array();
  $sql = "select id,user_email from users where user_email='".$email."' and user_password='".$userPassword."'";


  $result = $this->conn->query($sql);
  if($result != null && (mysqli_num_row($result)>=1)){
    $row = $result->fetch_array(MYSQLI_ASSOC);
    if(!empty($row)){
      retuenValue = $row;
    }
  }
  return $returnValue;
}

public function registeruser($email, $password){
  $sql = "insert into users set user_email=?,user_password=?";
  $statement = $this->conn->prepare($sql);

  if(!$statement)
  throw new Exception($statement->error);

  $statement->bind_param("ss", $email, $password);
  $returnValue = $statement->execute();

  return $returnValue;
}
}
?>
