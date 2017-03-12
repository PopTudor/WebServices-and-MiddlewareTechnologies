import re, os, sys


def main(argv):
    if len(argv) < 1:
        raise ValueError("Trebuie introdus numele fisierului")

    src = open(argv[1], 'r')
    dest = open("python_reversed.txt", 'w', 1)  # 1-buffered
    dest.truncate()
    # mentine pozitia unde o sa scriem datele in fisier, pornind de la coada la cap
    position = os.path.getsize(os.path.abspath(src.name))
    line = src.readline()
    # fals cand nu mai este nimic de citit
    while line:
        line = line[::-1]  # reverse line

        # mergi la pozitia corecta in fisier
        position -= len(line)
        dest.seek(position)

        # scrie rezultatul
        dest.write(line)
        line = src.readline()
    src.close()
    dest.flush()
    dest.close()

if __name__ == "__main__":
    main(sys.argv)