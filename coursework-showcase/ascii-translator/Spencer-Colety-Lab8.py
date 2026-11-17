# -------------------------------------+
# CSCI 127, Lab 8                      |
# October 17, 2023                     |
# Spencer Colety                       |
# -------------------------------------+
# It's different because they are the  |
# only ones that have words as the     |
# character instead of ! or a or b.    |
# -------------------------------------+

def create_dictionary(file_name):
    dictionary = {}
    file = open(file_name, 'r')
    next(file)
    for line in file:
        character, code, description = line.strip().split(',')
        dictionary[character] = int(code)
    file.close()
    return dictionary


def translate(sentence, dictionary, file_name):
    file = open(file_name, 'w')
    for character in sentence:
        if character == ' ':
            file.write('  32' + '\n')
        elif character == ",":
            file.write(', 44' + '\n')
        elif character in dictionary:
            file.write(character + ' ' + str(dictionary[character]) + '\n')
    file.close()

# --------------------------------------

def main():
    dictionary = create_dictionary("ascii-codes.txt")
    sentence = "Buck lived at a big house in the sun-kissed Santa Clara Valley. Judge Miller's place, it was called!"
    translate(sentence, dictionary, "output-1.txt")
    sentence = "Bozeman, MT  59717"
    translate(sentence, dictionary, "output-2.txt")
    sentence = "The value is ~$25.00"
    translate(sentence, dictionary, "output-3.txt")

# --------------------------------------

main()
