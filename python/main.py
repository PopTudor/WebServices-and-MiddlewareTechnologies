import re, os, sys, os.path
import random


def main(argv):
    if len(argv) < 1:
        raise ValueError("Trebuie introdus numele fisierului")

    src = open(argv[1], 'r',newline='\r\n')
    dest = open("python" + str(random.randrange(start=0, stop=100)) + "_reversed.txt", 'w')
    dest.truncate()
    # mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
    position = os.path.getsize(os.path.abspath(src.name))
    character = src.read(1)
    # fals cand nu mai este nimic de citit
    while character:
        # mergi la pozitia corecta in fisier
        position -= 1
        dest.seek(position)
        # scrie rezultatul
        dest.write(character)
        character = src.read(1)
    src.close()
    dest.close()


if __name__ == "__main__":
    main(sys.argv)
