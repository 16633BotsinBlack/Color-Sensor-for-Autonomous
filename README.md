# Color-Sensor-Autonomous

### Code to scan skystone blocks during autonomous for FTC SKYSTONE. 

* The only file you will need to modify is Auto_Load_Sample_Code_Side_Not_Specified in the [src folder] (https://github.com/16633BotsinBlack/Color-Sensor-for-Autonomous/tree/master/src) 

* The actual code that tests the color values of the blocks and decides what position to run starts at line 64 through line 118.

* This code only works for robots with TWO color sensors, one on each side (one per block). Basically, it is for scanning TWO blocks AT A TIME. See images for reference if you do not understand in [Reference Images Folder](https://github.com/16633BotsinBlack/REV-Color-Sensor-Autonomous-Code/tree/master/Reference%20Images)

To use it for your autonomous, modify the functions (lines 139 through 237) to fit your autonomous movements. The positions are accurate though so you might not need to change those.
