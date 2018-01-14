import socket
import os
import matplotlib.pyplot as plt
from matplotlib import transforms
import numpy as np

def shift(data):
    data = data.replace("\n","")
    points = data.split(',')
    x = []
    y = []
    for pts in points[1:]:
        x_, y_ = pts.split('+')
        x.append(x_)
        y.append(-1*int(y_))
    #x.reverse()
    #y.reverse()
    print x,y
    base = plt.gca().transData
    rot = transforms.Affine2D().rotate_deg(-180)

    plt.plot(x,y,'r-')
    #plt.plot(x,y, 'r-', transform= rot + base)
    plt.show()

os.system("adb forward tcp:15120 tcp:15120")
con = socket.socket()
con.connect(('localhost',15120))
con.send("Testing\n")
data = con.recv(1024)
if data == 'Testing\n':
    print "Success"
while (True):
    data = con.recv(4096)
    print data
    shift(data)
