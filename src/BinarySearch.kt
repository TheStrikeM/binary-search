fun main() {
    val exampleArray = intArrayOf(10,40,70,72,73,86,93,400)
    println(BinarySearch.getWithRecursive(exampleArray, key = 93))
    println(BinarySearch.getWithIterations(exampleArray, 93))
}

class BinarySearch {
    companion object {
        fun getWithIterations(filteredArray: IntArray, key: Int): Int {
            var low = 0
            var high = filteredArray.size - 1
            var middle: Int

            while (low <= high) {
                middle = low + (high - low) / 2
                when {
                    key < filteredArray[middle] -> high = middle -1
                    key > filteredArray[middle] -> low = middle + 1
                    key == filteredArray[middle] -> return middle
                }
            }
            return -1
        }

        fun getWithRecursive(filteredArray: IntArray, low: Int = 0, high: Int = filteredArray.size-1, key: Int): Int {
            if (low <= high && low < filteredArray.size-1) {
                var middle = low + (high - low) / 2
                when {
                    key == filteredArray[middle] -> return middle
                    key > filteredArray[middle] -> return getWithRecursive(filteredArray, middle+1, high, key)
                    key < filteredArray[middle] -> return getWithRecursive(filteredArray, low, middle-1, key)
                }
            }
            return -1
        }
    }
}