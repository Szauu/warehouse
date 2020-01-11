package warehouse.model.dto;

import javax.validation.constraints.NotNull;


public class OwnerDto {


    @NotNull
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public OwnerDto() {
    }

    public OwnerDto(@NotNull String name) {
        this.name = name;
    }

    private OwnerDto(Builder o) {
        this.name = o.name;
    }

    public String getName() {
        return name;
    }


    public static class Builder {
        private String name;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public OwnerDto build() {
            return new OwnerDto(this);
        }

    }

}
