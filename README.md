This is your new Play application
=================================

This file will be packaged with your application, when using `activator dist`.

|STEPS HOW TO CREATE A PLAY FRAMEWORK FORM|
|-----------------------------------------------------------------------------------------------|
| 1. Create an appropriate controller in the  `controllers` sub folder. |
| 2. Implement a `viewForm()` method to display the form passing the imported form as a parameter. Also create a `submit()` method = TODO    |
| 3. Create a form class in `models.dto`. Make the form a case class with a field for each field of the form |
| 4. Create a `val form = Form( mapping ( ... ))`. Remember to aplly and unapply the form.         |
| 5. Ensure the view form method is accessible from the routes in conf.        |
| 6. In `views` create a forms folder and a file: showForm.scala.html      |
| 7. View this file to see how to create the form and bring it into scope  |
| 8. Ensure the messages is implicitly defined in the FormsController and passed into scope in the Views.    |
| 9.    |