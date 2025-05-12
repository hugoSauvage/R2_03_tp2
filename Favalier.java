import java.util.ArrayList;

class Favalier extends Piece {

    public Favalier() {
        super('B', new Position());
    }

    public Favalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return new String("favalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Déplacements du Fou
        int[][] directionsFou = {
            {-1, 1},  // Haut-gauche
            {-1, -1}, // Bas-gauche
            {1, 1},   // Haut-droite
            {1, -1}   // Bas-droite
        };

        for (int[] direction : directionsFou) {
            boolean obstacle = false;
            int indiceX = positionDepartX + direction[0];
            int indiceY = positionDepartY + direction[1];
            while (!obstacle && (indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)) {
                Piece pi = pl.getCase(indiceX, indiceY);
                if (pi == null) {
                    liste.add(new Position(indiceX, indiceY));
                } else {
                    obstacle = true;
                    if (pi.getCouleur() != this.getCouleur()) {
                        liste.add(new Position(indiceX, indiceY));
                    }
                }
                indiceX += direction[0];
                indiceY += direction[1];
            }
        }

        // Déplacements du Cavalier
        int[][] mouvementsCavalier = {
            {-2, -1}, {-2, 1}, {-1, 2}, {1, 2},
            {2, 1}, {2, -1}, {1, -2}, {-1, -2}
        };

        for (int[] mouvement : mouvementsCavalier) {
            int indiceX = positionDepartX + mouvement[0];
            int indiceY = positionDepartY + mouvement[1];
            if ((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)) {
                Piece pi = pl.getCase(indiceX, indiceY);
                if (pi == null) {
                    liste.add(new Position(indiceX, indiceY));
                } else if (pi.getCouleur() != this.getCouleur()) {
                    liste.add(new Position(indiceX, indiceY));
                }
            }
        }

        return liste;
    }
}