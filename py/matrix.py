'''
MATRIX WHERE YOU FILL IT BY PUTTING IN A NUMBER
'''
def input_val(i, j, a, size, matr):
    for k in range(1, a):
        if matr[i][j]:
            i+=2
            j-=1
            if i>=size:
                i-=size
        matr[i][j]=k
        if i==0:
            i=size
        if j==size-1:
            j=-1

        j+=1
        i-=1

def print_m(a):
    for i in a:
        for j in i:
            print(j, end='  ')
        print()

def main():
    size=int(input('Define the size of the matrix: '))
    matr=[]
    for i in range(size):
        a=[]
        for j in range(size):
            a.append(0)
        matr.append(a)

    a=(size**2)+1
    i=int(input('Where is the row you want to beggin: '))
    j=int(input('Where is the column you want to beggin: '))
    
    input_val(i, j, a, size, matr)
    print_m(matr)

if __name__=='__main__':
    main()
