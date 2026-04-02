import heapq

class Nodo:
    def __init__(self, estado, padre, accion, profundidad):
        self.estado = estado
        self.padre = padre
        self.accion = accion
        self.profundidad = profundidad
    def obtener_sucesores(self,nodo):
        sucesores = []
        estado = nodo.estado
        i = estado.index(0)
        if i not in [0, 1, 2]:  # No está en la primera fila
            nuevo_estado = list(estado)
            nuevo_estado[i], nuevo_estado[i-3] = nuevo_estado[i-3], nuevo_estado[i]
            sucesores.append(("ARRIBA", tuple(nuevo_estado)))
        if i not in [6, 7, 8]:  # No está en la última fila
            nuevo_estado = list(estado)
            nuevo_estado[i], nuevo_estado[i+3] = nuevo_estado[i+3], nuevo_estado[i]
            sucesores.append(("ABAJO", tuple(nuevo_estado)))
        if i not in [0, 3, 6]:  # No está en la primera columna
            nuevo_estado = list(estado)
            nuevo_estado[i], nuevo_estado[i-1] = nuevo_estado[i-1], nuevo_estado[i]
            sucesores.append(("IZQUIERDA", tuple(nuevo_estado)))
        if i not in [2, 5, 8]:  # No está en la última columna
            nuevo_estado = list(estado)
            nuevo_estado[i], nuevo_estado[i+1] = nuevo_estado[i+1], nuevo_estado[i]
            sucesores.append(("DERECHA", tuple(nuevo_estado)))
        return sucesores


class Busquedas():
    def __init__(self):
        pass
    def dfs(self,inicial, objetivo):
        explorado = set()
        frontera = [Nodo(inicial, None, None, 0)]
        maxima_profundidad = 0
        nodos_generados = 0
        while frontera:
            nodo = frontera.pop()
            explorado.add(nodo.estado)
            if nodo.profundidad > maxima_profundidad:
                maxima_profundidad = nodo.profundidad
            if nodo.estado == objetivo:
                camino = []
                while nodo:
                    camino.append(nodo.accion)
                    nodo = nodo.padre
                return camino[::-1], nodos_generados
            for accion, estado in obtener_sucesores(nodo):
                if estado not in explorado:
                    frontera.append(Nodo(estado, nodo, accion, nodo.profundidad+1))
                    nodos_generados += 1
        return [], nodos_generados

    def distancia_manhattan(self,estado, objetivo):
        distancia = 0
        for i in range(3):
            for j in range(3):
                valor = estado[i*3+j]
                if valor != 0:
                    fila_objetivo = (valor - 1) // 3
                    columna_objetivo = (valor - 1) % 3
                    distancia += abs(fila_objetivo - i) + abs(columna_objetivo - j)

    def ascenso_colina(self,inicial, objetivo):
        print("entro")
        actual = Nodo(inicial, None, None, 0)
        nodos_generados = 1
        while actual.estado != objetivo:
            print(actual.estado)
            sucesores = obtener_sucesores(actual)
            if not sucesores:
                print("entro_1")
                return None, nodos_generados
            mejor_sucesor = max(sucesores, key=lambda x: self.distancia_manhattan(x[1], objetivo))
            if self.distancia_manhattan(mejor_sucesor[1], objetivo) >= self.distancia_manhattan(actual.estado, objetivo):
                print("entro_2")
                return None, nodos_generados
            actual = Nodo(mejor_sucesor[1], actual, mejor_sucesor[0], actual.profundidad + 1)
            nodos_generados += 1
            print("1")
            print("Movimiento: ", mejor_sucesor[0])
        camino = []
        while actual.accion:
            camino.append(actual.accion)
            actual = actual.padre
        camino.reverse()
        return camino, nodos_generados

    def evaluacion(self,nodo, estado_objetivo):
        return nodo.profundidad + self.distancia_manhattan(nodo.estado, estado_objetivo)

    frontera = []
    heapq.heappush(frontera, (evaluacion(nodo_inicial, estado_objetivo), nodo_inicial))

    def a_estrella(self,inicial, objetivo):
        explorado = set()
        frontera = [(self.distancia_manhattan(inicial, objetivo), Nodo(inicial, None, None, 0))]
        maxima_profundidad = 0
        nodos_generados = 0
        while frontera:
            _, nodo = heapq.heappop(frontera)
            explorado.add(nodo.estado)
            if nodo.profundidad > maxima_profundidad:
                maxima_profundidad = nodo.profundidad
            if nodo.estado == objetivo:
                camino = []
                while nodo:
                    camino.append(nodo.accion)
                    nodo = nodo.padre
                return camino[::-1], nodos_generados
            for accion, estado in obtener_sucesores(nodo):
                if estado not in explorado:
                    nuevo_nodo = Nodo(estado, nodo, accion, nodo.profundidad+1)
                    heapq.heappush(frontera, (nuevo_nodo.profundidad + distancia_manhattan(estado, objetivo), nuevo_nodo))
                    nodos_generados += 1
        return [], nodos_generados

class menu:
    def __init__(self):
        self.busquedas=Busquedas()
        self.load_menu()
    def menu_prompt(self):
        print("""

    Seleccione una de las opciones a continuación
    para calcular el puzzle 8 usando:
    1.Busqueda de primero en profundidad.
    2.Busqueda de ascenso de colina.
    3.Busqueda usando A* 
    4.Salir 

        """)
    def leer_configuracion(self,archivo):
        with open(archivo, "r") as file:
            lineas = file.readlines()
            inicial = tuple(map(int, lineas[0].split()))
            objetivo = tuple(map(int, lineas[1].split()))
            return inicial, objetivo
    def load_menu(self):
        while True:
            self.menu_prompt()
            inicial, objetivo = self.leer_configuracion("quiz.txt")
            opcion=int(input())
            if opcion==1:
                print("*-------------------------------------------------*")  
                print("Configuración inicial:")
                for i in range(3):
                    for j in range(3):
                        print(inicial[i*3+j], end=" ")
                print()
                print("Configuración final:")
                for i in range(3):
                    for j in range(3):
                        print(objetivo[i*3+j], end=" ")
                print()
                print("*-------------------------------------------------*")  
                camino, nodos_generados = self.busquedas.dfs(inicial, objetivo)
                if camino:
                    print("Solución encontrada:")
                    print(camino)
                    print("Número de nodos generados:", nodos_generados)
                else:
                    print("No se encontró solución.")
            elif opcion==2:
                print("*-------------------------------------------------*")  
                print("Configuración inicial:")
                for i in range(3):
                    for j in range(3):
                        print(inicial[i*3+j], end=" ")
                print()
                print("Configuración final:")
                for i in range(3):
                    for j in range(3):
                        print(objetivo[i*3+j], end=" ")
                print()
                print("*-------------------------------------------------*")
                camino, nodos_generados = self.busquedas.ascenso_colina(inicial, objetivo)
                if camino:
                    print("Solución encontrada:")
                    print(camino)
                    print("Número de nodos generados:", nodos_generados)
                else:
                    print("No se encontró solución.")
            elif opcion==3:
                print("*-------------------------------------------------*")  
                print("Configuración inicial:")
                for i in range(3):
                    for j in range(3):
                        print(inicial[i*3+j], end=" ")
                print()
                print("Configuración final:")
                for i in range(3):
                    for j in range(3):
                        print(objetivo[i*3+j], end=" ")
                print()
                print("*-------------------------------------------------*")  
                camino, nodos_generados = self.busquedas.a_estrella(inicial, objetivo)
                if camino:
                    print("Solución encontrada:")
                    print(camino)
                    print("Número de nodos generados:", nodos_generados)
                else:
                    print("No se encontró solución.")  
            elif opcion==4:
                break
            else:
                print("Opción inválida. Intente de nuevo.")
