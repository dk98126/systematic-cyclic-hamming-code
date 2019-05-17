# systematic-cyclic-hamming-code
implementation of systematic cyclic hamming code with parameters (7, 4, 3)
f(x) = x7+1
g(x) = x3+x+1
h(x) = x4+x2+x+1
coder codes information word (4 bits) this way, that decoder can fix one mistake (like 0100000, 0001000...) and decode code word correctly
