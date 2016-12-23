package fr.alexandre.test.eureka.service;

public class TaskDto {

    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {

        private TaskDto taskDto = new TaskDto();

        public Builder withTitle(String title) {
            taskDto.setTitle(title);
            return this;
        }

        public Builder withDescription(String description) {
            taskDto.setDescription(description);
            return this;
        }

        public TaskDto build() {
            return taskDto;
        }

    }

}
