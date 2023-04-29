from time import sleep

servo1Pos = 90
servo2Pos = 135
servo3Pos = 150
servo4Pos = 120
servo5Pos = 75

servo01 = 90
servo02 = 180
servo03 = 270
servo04 = 360
servo05 = 450

def vitrigaphang(servo1Pos, servo2Pos, servo3Pos, servo4Pos, servo5Pos):
    if (servo1Pos > servo01) :
        for j in range ( servo1Pos , servo01 -1 , -1) :
            sleep(.01) 
        servo1Pos = servo01
            
    elif (servo1Pos < servo01):
        for j in range ( servo1Pos , servo01 + 1, 1)   :
            sleep(.01)
        servo1Pos = servo01

    if (servo2Pos > servo02) :
        for j in range ( servo2Pos , servo02 -1 , -1) :
            sleep(.01) 
        servo2Pos = servo02
            
    elif (servo2Pos < servo02):
        for j in range ( servo2Pos , servo02 + 1, 1)   :
            sleep(.01)
        servo2Pos = servo02

    if (servo3Pos > servo03) :
        for j in range ( servo3Pos , servo03 -1 , -1) :
            sleep(.01) 
        servo3Pos = servo03
            
    elif (servo3Pos < servo03):
        for j in range ( servo3Pos , servo03 + 1, 1)   :
            sleep(.01)
        servo3Pos = servo03

    if (servo4Pos > servo04) :
        for j in range ( servo4Pos , servo04 -1 , -1) :
            sleep(.01) 
        servo4Pos = servo04
            
    elif (servo4Pos < servo04):
        for j in range ( servo4Pos , servo04 + 1, 1)   :
            sleep(.01)
        servo4Pos = servo04
    
    if (servo5Pos > servo05) :
        for j in range ( servo5Pos , servo05 -1 , -1) :
            sleep(.01) 
        servo5Pos = servo05
            
    elif (servo5Pos < servo05):
        for j in range ( servo5Pos , servo05 + 1, 1)   :
            sleep(.01)
        servo5Pos = servo05
    return servo1Pos, servo2Pos, servo3Pos, servo4Pos, servo5Pos

vitrigaphang(servo1Pos, servo2Pos, servo3Pos, servo4Pos, servo5Pos)

print(servo1Pos)
print(servo2Pos)
print(servo3Pos)
print(servo4Pos)
print(servo5Pos)