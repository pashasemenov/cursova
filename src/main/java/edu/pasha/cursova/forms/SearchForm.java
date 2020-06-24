package edu.pasha.cursova.forms;

public class SearchForm {
        private String string;

        public SearchForm() {
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return "SearchForm{" +
                    "string='" + string + '\'' +
                    '}';
        }
    }

