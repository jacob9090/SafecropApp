package com.jacob.fruitoftek.safecrop.facerecognition;

public interface SimilarityClassifier {

    /**
     * An immutable result recognized by a Classifier.
     */
    class Recognition {
        /**
         * A unique identifier for what has been recognized. Must be human-readable.
         */
        private final String id;

        /**
         * Display name for what has been recognized.
         */
        private final String title;

        /**
         * A distance measurement of the passed embedding.
         */
        private final Float distance;

        /**
         * Optional object for extra data. For example, location of the recognition in the image.
         */
        private Object extra;

        /**
         * Initializes a Recognition with an identifier, title, and confidence.
         *
         * @param id       An identifier for the recognized object.
         * @param title    A display name for the recognized object.
         * @param distance A distance measurement
         */
        public Recognition(final String id, final String title, final Float distance) {
            this.id = id;
            this.title = title;
            this.distance = distance;
            this.extra = null;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public Float getDistance() {
            return distance;
        }

        public void setExtra(Object extra) {
            this.extra = extra;
        }

        public Object getExtra() {
            return extra;
        }

        @Override
        public String toString() {
            String resultString = "";
            if (id != null) {
                resultString += "[" + id + "] ";
            }

            if (title != null) {
                resultString += title + " ";
            }

            if (distance != null) {
                resultString += String.format("(%.1f%%) ", distance * 100.0f);
            }

            return resultString.trim();
        }
    }
}
