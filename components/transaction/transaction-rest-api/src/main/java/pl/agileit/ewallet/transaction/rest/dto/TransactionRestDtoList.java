package pl.agileit.ewallet.transaction.rest.dto;

import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public class TransactionRestDtoList {

    private List<TransactionRestDto> dtos;

    public TransactionRestDtoList(final List<TransactionRestDto> dtos) {
        this.dtos = dtos;
    }

    public List<TransactionRestDto> getDtos() {
        return dtos;
    }

    public void setDtos(final List<TransactionRestDto> dtos) {
        this.dtos = dtos;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("dtos", dtos)
                .toString();
    }
}
