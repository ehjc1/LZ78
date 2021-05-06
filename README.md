# LZ78

## command chain preset:

'javac \*.java'
'cat <filename> | java LZencode | java LZdecode > out.txt'

e.g.
'cat MobyDick.txt | java LZencode | java LZdecode > out.txt'

## limitation:

Command chain preset only works on Linux machines
Command chain preset have been tested on Windows machines but failed
