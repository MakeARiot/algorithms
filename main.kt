fun main(){
    val arr = arrayOf<Int>(9, 6, 7, 2, 4, 1, 5, 3, 8)
    val sortedArr = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

}

//линейный поиск
fun linearSearch(A: Array<Int>, key: Int): Int{
    for (i in A){
        if (i == key) {
            return A[i]
        }
    }
    return -1
}

//бинарный поиск
fun binarySearch(A: Array<Int>, key: Int): Int{
    var left = 0
    var right = A.size-1

    while (left <= right){
        val middle = (left+right)/2

        if (A[middle] < key){
            left = middle + 1
        } else if (A[middle] > key){
            right = middle -1
        } else if (A[middle] == key) return middle
    }
    return -1
}

//быстрая сортировка
fun quickSort(array: IntArray, low: Int, high: Int) {
    if (array.size == 0) return  //завершить выполнение, если длина массива равна 0
    if (low >= high) return  //завершить выполнение если уже нечего делить

    // выбрать опорный элемент
    val middle = low + (high - low) / 2
    val opora = array[middle]

    // разделить на подмассивы, который больше и меньше опорного элемента
    var i = low
    var j = high
    while (i <= j) {
        while (array[i] < opora) {
            i++
        }
        while (array[j] > opora) {
            j--
        }
        if (i <= j) { //меняем местами
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
            i++
            j--
        }
    }

    // вызов рекурсии для сортировки левой и правой части
    if (low < j) quickSort(array, low, j)
    if (high > i) quickSort(array, i, high)
}

//сортировка Шелла
fun shellsSort(a: IntArray) {
    val n = a.size
    var step = n / 2
    while (step > 0) {
        for (i in step until n) {
            var j = i - step
            while (j >= 0 && a[j] > a[j + step]) {
                val x = a[j]
                a[j] = a[j + step]
                a[j + step] = x
                j -= step
            }
        }
        step /= 2
    }
}