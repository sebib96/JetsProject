# JetsProject
Third week project at Skill Distillery. The program allows for a user to access a menu where they would be able to:

1. List all the Jets in the fleet.
2. *Scramble* all the Jets in the fleet.
3. View the fastest Jet in the fleet.
4. View the Jet with the longest range in the fleet.
5. *Load* all Cargo Jets.
6. Simulate a dogfight between Fighter Jets in the fleet.
7. Add a (Cargo, Fighter, or Commercial) Jet to a fleet.
8. Remove a Jet from the fleet.
9. Quit the program.

The Jets are imported from a txt file that first casts parses the Jet type, model, speed, range, and price into an array. From there the Jet objects are generated based on their model and assigned to an array list.

The JetsImpl class exists as the class for commercial Jets while the FighterJet and CargoPlane class exist for their respective Jet types. 

## Technologies Used
Eclipse, Java, Sublime.

## Lessons Learned
First time manipulating exception handling. My primary focus was on handling exceptions that could be generated mainly from user input. 
