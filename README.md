# Team3I400FinalProject
Earthquake Data for our final project.
<<<<<<< HEAD
Team 3: Alex Groves, Jack Arno, Orion Ingleheart
Earthquake Documentation
We created a JavaFx project because we mistakenly thought GUIs were going to be used in part 1. 
Then, someone said that GUIs were going to be used in part 2, so we kept the project as a Fx one since we’ll need it for part 2. 
There 3 other branches besides master. One for each role: Architect, Documenter, and Tester. 
We have a main.java file and an Earthquake.java file. 
The main.java file collects the csv file, using Scanner and java.io, that contains all the earthquake events. 
We edited the all_month.csv file and replaced the comma in the place field with a space.
Then, we split the file by commas on the headers. 
Then, we split the content of the file by commas and ran through each line and inputting it in an arraylist, using a while loop 
and the .add method. The arraylist consists of all the earthquake events where each event is a point in the arraylist. 
We created a earthquake class with all the fields from the all_month.csv file as string variables. The class also had getter methods for all the variables. It also had comparator methods for the printby function. These methods would take the inputted values and compare it with the field it's comparing. If they're the same it'll add it to the printed list. This creates a sorted list.
The file also has the command line interface code. This prints out a line asking for a command. 
It’ll keep printing this line after a command is run until “quits” is inputted. 
The options are help, summary, print, printby, and search. 
It uses a switch case on the user’s input to determine which command it should run or if it needs to print out the error statement 
saying that it’s not an available command. Help prints out a summary of each command and how to call them. 
Summary prints out the number of events and a time range of the events. It will also show the average values of magnitude, gap, nst, and rms.
We ran into errors with making the input .toLowerCase() with the camel case variables, so we had to take away the camel case on the switch case variables. 
The average values are grabbed by casting the values to doubles and adding them to a total then dividing by length of the array.
We get the # of events with getter functions and the .size() method.
Print prints out all the data from the events using the toString method.
Print by does the same thing but it’ll sort the data by whatever field the user inputs. 
we ran into a lot of problems with the printby function, because we set the earthquake class variables to string on all of them. This made us cast the variable to doubles and int where necessary in the comparator functions. 
It will sort by ascending order based on the field chosen, using comparables and the comparator and getter values.
It will be done by using comparators and getter functions from the earthquake class. It then prints the values sorted by the field given.
When you call print by it will ask for another input for the field to sort the data by. 
Search will print out the data fields that the user searched for. 
When you call search it will ask for another input for the field to search for.
It uses the getter methods to print out the data from the inputted field and a switch case method to obtain the specific getter
that's called. It then uses a for loop to print that field from all the events. The earthquake.java has the earthquake class set up. 
These objects are created from the earthquake events and all the variables are all of the columns from the csv file. 
They’re all string variables. The toString method prints out the name of the field and then the data associated with the field. 
=======
Earthquake Data for our final project. Team 3: Alex Groves, Jack Arno, Orion Ingleheart Earthquake Documentation We created a JavaFx project because we mistakenly thought GUIs were going to be used in part 1. Then, someone said that GUIs were going to be used in part 2, so we kept the project as a Fx one since we’ll need it for part 2. There 3 other branches besides master. One for each role: Architect, Documenter, and Tester. We have a main.java file and an Earthquake.java file. The main.java file collects the csv file, using Scanner and java.io, that contains all the earthquake events. We edited the all_month.csv file and replaced the comma in the place field with a space. Then, we split the file by commas on the headers. Then, we split the content of the file by commas and ran through each line and inputting it in an arraylist, using a while loop and the .add method. The arraylist consists of all the earthquake events where each event is a point in the arraylist. We created a earthquake class with all the fields from the all_month.csv file as string variables. The class also had getter methods for all the variables. It also had comparator methods for the printby function. These methods would take the inputted values and compare it with the field it's comparing. If they're the same it'll add it to the printed list. This creates a sorted list. The file also has the command line interface code. This prints out a line asking for a command. It’ll keep printing this line after a command is run until “quits” is inputted. The options are help, summary, print, printby, and search. It uses a switch case on the user’s input to determine which command it should run or if it needs to print out the error statement saying that it’s not an available command. Help prints out a summary of each command and how to call them. Summary prints out the number of events and a time range of the events. It will also show the average values of magnitude, gap, nst, and rms. We ran into errors with making the input .toLowerCase() with the camel case variables, so we had to take away the camel case on the switch case variables. The average values are grabbed by casting the values to doubles and adding them to a total then dividing by length of the array. We get the # of events with getter functions and the .size() method. Print prints out all the data from the events using the toString method. Print by does the same thing but it’ll sort the data by whatever field the user inputs. we ran into a lot of problems with the printby function, because we set the earthquake class variables to string on all of them. This made us cast the variable to doubles and int where necessary in the comparator functions. It will sort by ascending order based on the field chosen, using comparables and the comparator and getter values. It will be done by using comparators and getter functions from the earthquake class. It then prints the values sorted by the field given. When you call print by it will ask for another input for the field to sort the data by. Search will print out the data fields that the user searched for. When you call search it will ask for another input for the field to search for. It uses the getter methods to print out the data from the inputted field and a switch case method to obtain the specific getter that's called. It then uses a for loop to print that field from all the events. The earthquake.java has the earthquake class set up. These objects are created from the earthquake events and all the variables are all of the columns from the csv file. They’re all string variables. The toString method prints out the name of the field and then the data associated with the field.
>>>>>>> branch 'finalMaster' of https://github.iu.edu/jamakick/Team5EarthquakePhase2.git
