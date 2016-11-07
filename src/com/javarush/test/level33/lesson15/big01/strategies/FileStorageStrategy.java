package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by rolep on 21/04/16.
 */
public class FileStorageStrategy implements StorageStrategy {


    long bucketSizeLimit = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    int size;

    int hash(Long k) {
        return k.hashCode();
    }

    int indexFor(int h, int length) {
        return h & (length-1);
    }

    Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }

        int hash = (key == null) ? 0 : hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] == null) return null;
        for (Entry e = table[index].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    void resize(int newCapacity) {
        //FileBucket[] oldTable = table;
        //int oldCapacity = oldTable.length;
        //if (oldCapacity == (1 << 30)) {
        //    return;
        //}

        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;

    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (FileBucket fb : table) {
            if (fb == null) continue;
            Entry e = fb.getEntry();
            while(null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                if (newTable[i] == null) {
                    newTable[i] = new FileBucket();
                    e.next = null;
                }
                else {
                    e.next = newTable[i].getEntry();
                    //newTable[i].remove();
                }
                newTable[i].putEntry(e);
                e = next;
            }
            fb.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        //if ((null != table[bucketIndex]) && (table[bucketIndex].getFileSize() >= bucketSizeLimit) ) {
            //resize(2 * table.length);
            //hash = (null != key) ? hash(key) : 0;
            //bucketIndex = indexFor(hash, table.length);
        //}


        createEntry(hash, key, value, bucketIndex);
        if ((null != table[bucketIndex]) && (table[bucketIndex].getFileSize() > bucketSizeLimit) ) {
            resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = null;
        if (table[bucketIndex] != null) {
            e = table[bucketIndex].getEntry();
            //table[bucketIndex].remove();
        }
        else {
            table[bucketIndex] = new FileBucket();
        }
        //e = table[bucketIndex].getEntry();
        //table[bucketIndex].remove(); //
        //table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        //System.out.println(table[bucketIndex].getEntry());
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++) {
            if (tab[i]  == null) continue;
            for (Entry e = tab[i].getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
/*
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);

        FileBucket fb = table[i];
        if (fb != null) {
            Entry parent = fb.getEntry();
            for (Entry e = parent; e != null; e = e.next) {
                if (key.equals(e.key)) {
                    e.value = value;
                    fb.remove();
                    fb.putEntry(parent);
                    return;
                }
            }
        }

        addEntry(hash, key, value, i);
    }
*/
    public void put(Long key, String value)
    {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        if (table[i] != null) {
            Entry e = table[i].getEntry();
            while (e != null) {
                if (e.getKey().equals(key)) {
                    e.value = value;
                    return;
                }
                e = e.next;
            }
            addEntry(hash, key, value, i);
        }
        else {
            createEntry(hash, key, value, i);
        }
    }


    @Override
    public Long getKey(String value) {
        if (value == null) {
            return 0l;
        }
        for (FileBucket aTable : table)
        {
            if (aTable == null) continue;
            for (Entry e = aTable.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return aTable.getEntry().getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);

        return null == entry ? null : entry.getValue();
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
