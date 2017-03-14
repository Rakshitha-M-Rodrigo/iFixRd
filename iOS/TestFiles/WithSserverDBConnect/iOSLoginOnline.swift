@IBAction func loginButtonTapped(sender:AnyObject){
  let userEmail = userEmailTextField.text;
  let userPassword = userPasswordTextField.text;

  if(userPassword.isEmpty || userEmail.isEmpty) {
    return;
  }

  // send user data to servver side
  let myUrl = NSURL(string:"http://www.earthlandia.com/user-regiter/userLogin.php");
  let request = NSMutableURLRequest(URL:myUrl!);
  request.HTTPMethod = "POST";

  let postString = "email=\(userEmail)&password\(userPassword)";

  request.HTTPBody = postString.dataUsingEncoding(NSUTF8StringEncoding);

  let task = NSURLSession.sharedSession().dataTaskWithRequest(request){
    data, response, error in

    if error != nil {
      println("error=\(error)")
      return
    }
    var err: NSError?
    var json = NSJSONSerialization.JSONObjectWithData(data, options: .MutableContainers, error: &err) as? NSDictionary

    if let parseJSON = json {
      var resultValue:String = parseJSON["status"] as String!;
      println("result: \(resultValue)")

      if(resultValue == "Success"){
        //login is successfull
        NSUserDefaults.standardUserDefaults().setBool(true, forKey:"isUserLoggedIn");
        NSUserDefaults.standarduserDefaults().synchronize();

        self.dismissViewControllerAnimated(true, completiion: nil);
      }
    }
  }
  task.resume()
}
