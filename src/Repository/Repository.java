package Repository;

/**
 * Abstract class for the repository.
 */
abstract class Repository {
    /**
     * Abstract method for reading from a file that needs to be implemented.
     */
    abstract void readFile();

    /**
     * Abstract method for saving to a file that needs to be implemented.
     */
    abstract void saveFile();
}
