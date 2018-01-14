import numpy
from matplotlib import pyplot, transforms

datax= [I for I in range(100)]
datay = datax

# first of all, the base transformation of the data points is needed
base = pyplot.gca().transData
rot = transforms.Affine2D().rotate_deg(270)

# define transformed line
line = pyplot.plot(datax,datay, 'r-', transform= rot + base)

# or alternatively, use:
# line.set_transform(rot + base)

pyplot.show()