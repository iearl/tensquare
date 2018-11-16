package eneity;

import java.util.List;

/**
 * 返回结果集合，分页时使用
 * @param <T>
 */
public class PaggResult<T> {
    private long total;
    private List<T> rows;

    public PaggResult() {
    }

    public PaggResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
